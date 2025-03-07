Feature: Test One Stream Feature
  Scenario: Post to the OneStream
    When I request the onestream endpoint "/version"
    Then the response of onestream should be "0.0.1"
    And the status code of onestream is 200
