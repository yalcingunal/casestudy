Feature: Trendyol Assignment

    Scenario: User should be signed in
        Given Customer is on the HomePage
        When Customer login with "yalcingunal@gmail.com" email and "998999" password
        Then Customer should see "Hesabım" text on UserIcon

    Scenario Outline: User should see images on Boutique
        Given Customer is on the HomePage
        And Customer login with "yalcingunal@gmail.com" email and "998999" password
        When Customer visits "<Category>" main category
        Then Customer should see all images on Category
        Examples:
            | Category |
            | 1        |
            | 2        |
            | 3        |
            | 4        |
            | 5        |
            | 6        |
            | 7        |
            | 8        |
            | 9        |
            | 10       |

    Scenario: User should see images on random Boutique
        Given Customer is on the HomePage
        And Customer login with "yalcingunal@gmail.com" email and "998999" password
        And Customer visits random main category
        When Customer visits random Boutique
        Then Customer should see all images on Boutique

    Scenario: User should add to basket a product on random Boutique
        Given Customer is on the HomePage
        And Customer login with "yalcingunal@gmail.com" email and "998999" password
        And Customer visits random main category
        And Customer visits random Boutique
        When Customer adds to basket a random product
        Then Customer should see selected product in the basket
