package com.app.handcraft.web.restcontroller;

import com.app.handcraft.dto.OptionCount;
import com.app.handcraft.dto.PollTransformer;
import com.app.handcraft.dto.VoteResult;
import com.app.handcraft.dto.VoteTransformer;
import com.app.handcraft.exception.ResourceNotFoundException;
import com.app.handcraft.service.QuickPollService;
import com.app.handcraft.web.model.Poll;
import com.app.handcraft.web.model.Vote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class QuickPollController {

    @Autowired
    QuickPollService quickPollService;

    @Autowired
    PollTransformer pollTransformer;

    @Autowired
    VoteTransformer voteTransformer;


    @RequestMapping(value = "/polls", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        List<com.app.handcraft.entity.Poll> allEntityPolls = quickPollService.findAllPolls();
        List<com.app.handcraft.web.model.Poll> allModelPolls = allEntityPolls.stream().map(poll -> pollTransformer.transfer(poll)).collect(Collectors.toList());
        return new ResponseEntity<>(allModelPolls, HttpStatus.OK);
    }

    @RequestMapping(value = "/polls", method = RequestMethod.POST)
    public ResponseEntity<?> createPoll(@Valid @RequestBody Poll poll) {
        com.app.handcraft.entity.Poll pollEntity = quickPollService.createPoll(pollTransformer.transfer(poll));
        poll = pollTransformer.transfer(pollEntity);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getId())
                .toUri();
        responseHeaders.setLocation(newPollUri);
        log.info("poll id >> " + poll.getId().toString());
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/polls/{pollId}", method = RequestMethod.GET)
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
        verifyPoll(pollId);
        Optional<com.app.handcraft.entity.Poll> pollOptional = quickPollService.findOnePoll(pollId);
        return new ResponseEntity<>(pollTransformer.transfer(pollOptional.get()), HttpStatus.OK);
    }

    @RequestMapping(value = "/polls/{pollId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        Optional<com.app.handcraft.entity.Poll> pollOptional = quickPollService.findOnePoll(pollId);
        if (!pollOptional.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        // Save the entity
        com.app.handcraft.entity.Poll pollEntity = quickPollService.createPoll(pollTransformer.transfer(poll));
        poll = pollTransformer.transfer(pollEntity);
        return new ResponseEntity<>(poll, HttpStatus.OK);
    }

    @RequestMapping(value = "/polls/{pollId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        Optional<com.app.handcraft.entity.Poll> pollOptional = quickPollService.findOnePoll(pollId);
        if (!pollOptional.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        quickPollService.deletePoll(pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/polls/{pollId}/votes", method = RequestMethod.POST)
    public ResponseEntity<?> createVote(@PathVariable Long pollId, @RequestBody Vote vote) {
        com.app.handcraft.entity.Vote voteEntity = quickPollService.createVote(voteTransformer.transfer(vote));
        vote = voteTransformer.transfer(voteEntity);
        // Set the headers for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}").buildAndExpand(vote.getId()).toUri());
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/polls/{pollId}/votes", method = RequestMethod.GET)
    public Iterable<com.app.handcraft.entity.Vote> getAllVotes(@PathVariable Long pollId) {
        return quickPollService.findByPoll(pollId);
    }

    @RequestMapping(value = "/polls/votes", method = RequestMethod.GET)
    public Iterable<com.app.handcraft.entity.Vote> getVotes() {
        return quickPollService.findAllVotes();
    }

    @RequestMapping(value = "/computeresult", method = RequestMethod.GET)
    public ResponseEntity<?> computeResult(@RequestParam Long pollId) {
        VoteResult voteResult = new VoteResult();
        Iterable<com.app.handcraft.entity.Vote> allVotes = quickPollService.findByPoll(pollId);
        // Algorithm to count votes
        int totalVotes = 0;
        Map<Long, OptionCount> tempMap = new HashMap<Long, OptionCount>();
        for (com.app.handcraft.entity.Vote v : allVotes) {
            totalVotes++;
            // Get the OptionCount corresponding to this Option
            OptionCount optionCount = tempMap.get(v.getOpt().getId());
            if (optionCount == null) {
                optionCount = new OptionCount();
                optionCount.setOptionId(v.getOpt().getId());
                tempMap.put(v.getOpt().getId(), optionCount);
            }
            optionCount.setCount(optionCount.getCount() + 1);
        }
        voteResult.setTotalVotes(totalVotes);
        voteResult.setResults(tempMap.values());
        return new ResponseEntity<VoteResult>(voteResult, HttpStatus.OK);
    }

    protected void verifyPoll(Long pollId) throws ResourceNotFoundException {
        Optional<com.app.handcraft.entity.Poll> poll = quickPollService.findOnePoll(pollId);
        if (!poll.isPresent()) {
            throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
        }
    }

}
