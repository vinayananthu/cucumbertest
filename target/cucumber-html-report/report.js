$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("MyApp.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 20,
  "name": "Title of your feature",
  "description": "I want to use this template for my feature file",
  "id": "title-of-your-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 19,
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "line": 24,
  "name": "Test login with valid credentials",
  "description": "",
  "id": "title-of-your-feature;test-login-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 23,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "Open Chrome",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "start application",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "I enter valid \"vananthu\" and valid \"Vny@5145\"",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "user should be able to login successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "SmokeTest2.open_firefox()"
});
formatter.result({
  "duration": 5626074786,
  "status": "passed"
});
formatter.match({
  "location": "SmokeTest2.start_application()"
});
formatter.result({
  "duration": 4013950120,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "vananthu",
      "offset": 15
    },
    {
      "val": "Vny@5145",
      "offset": 36
    }
  ],
  "location": "SmokeTest2.i_enter_valid_username_and_valid_password(String,String)"
});
formatter.result({
  "duration": 340543249,
  "status": "passed"
});
formatter.match({
  "location": "SmokeTest2.user_should_be_able_to_login_successfully()"
});
formatter.result({
  "duration": 528696559,
  "status": "passed"
});
});