Feature: Test One Stream Feature

  Scenario Outline: Post to the OneStream
    Given I request the onestream request object for "<applicationID>"
    When I call the onestream API with the requestObject
    Then the response of onestream should be 200

    Examples:
      | applicationID |
      | abcd-1111     |
      | abcd-2222     |
      | abcd-3333     |
      | abcd-4444     |
      | abcd-5555     |