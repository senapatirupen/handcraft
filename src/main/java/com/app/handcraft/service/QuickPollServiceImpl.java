package com.app.handcraft.service;

import com.app.handcraft.entity.Poll;
import com.app.handcraft.entity.Vote;
import com.app.handcraft.repository.OptionRepository;
import com.app.handcraft.repository.PollRepository;
import com.app.handcraft.repository.VoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class QuickPollServiceImpl implements QuickPollService {

    private PollRepository pollRepository;
    private OptionRepository optionRepository;
    private VoteRepository voteRepository;

    public QuickPollServiceImpl(PollRepository pollRepository, OptionRepository optionRepository, VoteRepository voteRepository){
        this.pollRepository = pollRepository;
        this.optionRepository = optionRepository;
        this.voteRepository = voteRepository;
    }

    @Override
    public Poll createPoll(Poll poll){
        log.info("Poll detail >> "+ poll.toString());
        return pollRepository.save(poll);
    }

    @Override
    public List<Poll> findAllPolls(){
        return pollRepository.findAll();
    }

    @Override
    public Optional<Poll> findOnePoll(Long id){
        return pollRepository.findById(id);
    }

    @Override
    public void deletePoll(Long id){
        pollRepository.deleteById(id);
    }

    @Override
    public Iterable<Vote> findByPoll(Long  id) {
        return voteRepository.findByPoll(id);
    }

    @Override
    public Vote createVote(Vote vote){
        log.info("Vote detail >> "+ vote.toString());
        optionRepository.save(vote.getOpt());
        return voteRepository.save(vote);
    }

    @Override
    public List<Vote> findAllVotes(){
        return voteRepository.findAll();
    }

    @Override
    public Optional<Vote> findOneVote(Long id){
        return voteRepository.findById(id);
    }

    @Override
    public void deleteVote(Long id){
        voteRepository.deleteById(id);
    }


}
