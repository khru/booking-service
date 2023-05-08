# Understanding

## US1 - Insure confirmed bookings

![US1 Insure confirmed bookings_2023-04-18.png](./doc/US1%20Insure%20confirmed%20bookings_2023-04-18.png)

As a hotel chain,
I want to insure my bookings whenever they are confirmed

```Gherkin
Feature: Insure bookings when confirmed

Scenario: Insure booking when confirmation arrives

Given a booking has been made
When a confirmation is received
Then the booking should be insured
```

**Definition of Done**
Given a booking, when a confirmation arrives, then insure the booking.

## US2 - Reinsure bookings according to modifications

![US2 Reinsure bookings according to modifications_2023-04-18.png](./doc//US2%20Reinsure%20bookings%20according%20to%20modifications_2023-04-18.png)

```Gherkin
As a hotel chain,
I want to reinsure my bookings whenever they are modified

Scenario: Reinsure booking when modification arrives

Given an insured booking exists
When the booking is modified
Then the booking should be reinsured with the newer information
```

**Definition of Done**
Given an insured booking, when a modification arrives, then reinsure the booking with the newer information.

## US3 - Invoice insured bookings

![US3 Invoice insured bookings_2023-04-18.png](./doc//US3%20Invoice%20insured%20bookings_2023-04-18.png)

**Definition of Done**
Given some bookings insured, when someone ask for them, then list all insured bookings with its premium amount.

## US4 - Generate a report of cancelled insured bookings

![US4 Generate a report of cancelled insured bookings_2023-04-18](./doc//US4%20Generate%20a%20report%20of%20cancelled%20insured%20bookings_2023-04-18.png)

```Gherkin
Feature: View canceled insured bookings

  As a staff member,
  I want to list all the canceled insured bookings
  So that I can easily view the financial impact of these bookings.

  Scenario: List canceled insured bookings

    Given some bookings have been insured
    And the booking has been cancel
    When I request to view the canceled insured bookings
    Then I should see a list of all canceled insured bookings
```

**Important questions**:
- Who would be that staff member? (would be somebody from outside the company or not)
- What's the value we want to achive with this?
- Could on a first iteration be enough with the listing without the premium price?


**Definition of Done**
Given some cancelled insured bookings, when someone ask for them, then list them all.


## Assumptions
1. Since the only thing that is required is that there be a 200 so that the clients know that the message has arrived, I have decided not to do the exercise with a framework that manages the responses.
2. Since we only have 1 client, I am not going to add the Booking dependency of knowing different time zones, even though it would be one of the first points to attack in the following implementations.
3. Currency would be EUR for now
4. I could have created 2 more classes
    * FlexibleInsured (this could contain a price)
    * Price -> in JVM an implementation of the JSR 354 – "Currency and Money")
5. Because I know that I will not call any API I did not put too much effort on the DTO
