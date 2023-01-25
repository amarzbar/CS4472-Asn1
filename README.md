## CS 4472A -- Software Specification, Testing, and Quality Assurance
Repo for CS4472 Group Assignment 1. More to come.



**The Testing Targets**
You will perform black box testing on the following classes

__*atm.Session.java*:__ The focus here is to check for **PIN format** and **valid amount chosen for a withdrawal transaction** (transaction choice 1) as per the business logic presented above for ATM Session. The technique to use for this test is __Robust Worst Case Boundary Value Analysis__ under the single fault assumption principle. In the program provided a withdrawal is limited to the available balance of the account and the daily limit. For this assignment, you must create an account with a daily limit of $1000 and an available balance of $5,000. The daily limit of $1000 is your upper boundary in this case.


__*bank.FeesCalculator.java*__: The focus here is to **check for the correct calculation of fees while performing withdrawal, deposit, and transfer**.
For withdrawal: Use Robust Worst Case Boundary Value Analysis to generate your test cases.
For deposit: Use Weak Robust Equivalence Class Analysis to generate your test cases.
For transfer: Use Decision Table Analysis to generate your test cases.
