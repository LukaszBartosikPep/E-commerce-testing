Feature: QA


  @Slider

  Scenario: Move the slider

    Given I open the slider site


  @Date

  Scenario: Move the slider

    Given I open the "https://demoqa.com/date-picker" site
    Then I pick and compare date "July"

  @Links
    Scenario: Check if links are valid

      Given I open the "https://demoqa.com/broken" site
      Given I check if URL valid
  @Img

    Scenario:Check if img is loaded
      Given I open the "https://demoqa.com/broken" site
      Given I check if img valid

    @Time

    Scenario: How long after element visible
      Given I open the "https://demoqa.com/dynamic-properties" site
      Then I retrieve the time
      
    @Inter
    
    Scenario: Change size of box
      Given I open the "https://demoqa.com/resizable" site
      Given I change the size of box
