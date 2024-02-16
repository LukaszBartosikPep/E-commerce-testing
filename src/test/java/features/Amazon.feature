Feature: Amazon

    #TODO Use Standard_user to order one item and checkout, check if after clicking Back Home it is working properly
    #TODO Use assertion when needed
  @SU_One_Item
  Scenario: Standard user Orders One Item
    Given Amazon is opened
    When I check reviews number
    When I check if table valid
    When I check percentage of stars

  @Comments
  Scenario: Check how many reviews with comment
    Given Amazon is opened
    When I check how many comments













