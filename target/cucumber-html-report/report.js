$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/AddAListing1.feature");
formatter.feature({
  "name": "Test add a listing process.",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@AddAListing"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I login to \"Xadmin\"",
  "keyword": "Given "
});
formatter.match({
  "location": "TestStepDefinitions.i_login_to(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify data entered during Listing creation is imported correctly into regular order.",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@AddAListing"
    },
    {
      "name": "@C2671"
    },
    {
      "name": "@Sample"
    }
  ]
});
formatter.step({
  "name": "I Start running test case \"C2671\"",
  "keyword": "When "
});
formatter.match({
  "location": "TestStepDefinitions.site_is_open(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "end of test.",
  "keyword": "Then "
});
formatter.match({
  "location": "TestStepDefinitions.end_of_test()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("features/C701.feature");
formatter.feature({
  "name": "Order Main Agent work flow  for Coldwell Bank Florida.",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@orderMain"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I impersonate \"Agent\" user \"325DEMODEM\"",
  "keyword": "Given "
});
formatter.match({
  "location": "TestStepDefinitions.i_impersonate_user(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify that if pdf download function is unchecked - it will not be available at the order complete page.",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@orderMain"
    },
    {
      "name": "@C701"
    },
    {
      "name": "@Sample"
    }
  ]
});
formatter.step({
  "name": "I Start running test case \"C701\"",
  "keyword": "When "
});
formatter.match({
  "location": "TestStepDefinitions.site_is_open(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "end of test.",
  "keyword": "Then "
});
formatter.match({
  "location": "TestStepDefinitions.end_of_test()"
});
formatter.result({
  "status": "passed"
});
});