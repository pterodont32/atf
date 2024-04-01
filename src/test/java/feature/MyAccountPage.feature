Feature:  My account page


  Scenario: Check that user is able to log in and log out
    Given user is on My account page
    When user populate "pterodont32@gmail.com" and "Gap31s3gs3ggap" fields
    And  'LOG IN' button is clicked
    Then user is successfully logged in
    When  'LOG OUT' button is clicked
    Then user is successfully logged out


#  Scenario Outline: Check that user is not  able to log in with invalid credentials
#    Given user is on My account page
#    When user populate "<username>" and "<password>" fields
#    And  'LOG IN' button is clicked
#    Then user should see an error message
#
#    Examples:
#      | username | password |
#      | Athens1  | Regular  |

#      | admin                 | Gap31s3gs3ggap        |
#      | pterodont32@gmail.com | pterodont32@gmail.com |
#      | Gap31s3gs3ggap        | Premium               |

#  Scenario Outline: Register with already registered email
#    Given user is on My account page
#    When user fill in the registration form with the following details:
#      | USERNAME   | EMAIL ADDRESS | PASSWORD   |
#      | <Username> | <Email>       | <Password> |
#    And 'Register' button is clicked
#    Then user should see an error message indicating the email is already registered
#
#    Examples:
#      | Username | Email                              | Password                     |
#      | elf321   | pterodont32@gmail.com              | Gap31s3gs3ggapGap31s3gs3ggap |
#      | tester   | already-registered@test-domain.com | test456                      |