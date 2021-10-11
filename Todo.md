## User Interaction
###SignUp:
SignUp fail >> emailId, mobile number already exist
SignUp Success >>
###SignIn
SignIn fail >> forgot password
reset password with emailId/Mobile number
fail to reset password
emailId/Mobile number does not exist
forgot email
enter mobile number and dob to view emailId
forgot mobile
enter email and dob to view mobile
reset password success
login using new password
SingIn Success
View User Detail on Screen
###AddAddress to user
create Address
update address
get all address
### product
add product
view product
edit product
list of products
### Cart
add empty cart to user at the time of user sign up
add product to cart
delete product from cart
view all the products in cart
delete product from list of products in cart
add the product to list of products in cart
transfer all the product to order and make cart empty
### Order
get transfer all the product from cart to order after transfer
remove product from order
add delivery address to order
show order summary with all the list of products and delivery address and expected delivery date
make a call to verify the order



show all the price summary on order
add product to order
add billing address to order
add delivery address to order
add payment method to order
once payment is made generate order summary
shipment should delivered
order status will be completed
order invoice will be generated and shared with user
return or cancel is not available
### order shipment
shipment start
shipment for order picked from address
shipment for order delivered to address
shipment status
shipment completed order completed
https://github.com/eugenp/tutorials/tree/master/orika
https://www.baeldung.com/orika-mapping
https://intellitech.pro/tutorial-3-spring-boot-rest-web-services-using-swagger-and-orika/

##### Java immutable Pojo with lombok
https://www.baeldung.com/lombok-builder-singular
https://projectlombok.org/features/BuilderSingular

##### Junit 5 assertThrows() for testing exception
https://howtodoinjava.com/junit5/expected-exception-example/


Address type: HOME, WORK, BILLING, DELIVERY
Order type: NEW(when products are moved from cart to order)
            Only one order will be available as START in Orders for a user
            So that we can pick it for recent edit
            DELIVERY-ADDRESS(when order is picked to add delivery address to it
            and having order status as START)
            after adding the delivery address we will change the status to DELIVERY-ADDRESS
            SUMMARY(when order is finalized and delivery address is added to order)
            the previous status should be DELIVERY-ADDRESS to pick
            OPEN(when order confirmation is done though call)
            and having previous order status as ORDER-SUMMARY
            SHIPPING-ADDRESS(when Shipping address is added to order and ready to shipped)
            previous status should be ORDER-OPEN
            ORDER-SHIPPED(when order is shipped through any courier)
            and previous status should be OPEN
            ORDER-DELIVERED(when order is delivered to the customer)
            CLOSED
            
Order message: You may pick up your order by placing your expected visit date or we will deliver
               the product at you address.
               For both the option if stock is not available then making time will be applicable
               So please make the order prior to 15days you are expecting the order
It is good to have this message on front screen

               