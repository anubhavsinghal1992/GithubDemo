Feature: Application Login

Scenario Outline: Validate Login - Positive Case
Given Intitiate Chrome Browser
When user clicks on login button and provide credentials as <validUsername> and <validPassword>
Then Post Login page is displayed
And Close the browser

Examples:
|validUsername					|validPassword			|
|anubhav@abc.com				|test123						|
|singhal@abc.com				|test456						|


Scenario: Validate Login - Negative Case
Given Intitiate Chrome Browser
When user clicks on login button and provide credentials as "abhishek.singhal1990@gmail.com" and "test456"
Then Error is shown for wrong credentials
And Close the browser