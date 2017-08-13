  angular.module("app", []).controller("home", function($http) {
    var self = this;
    $http.get("/v1/user/details").success(function(data) {
      self.user = data.userAuthentication.details.name;
      self.authenticated = true;
    }).error(function() {
      self.user = "N/A";
      self.authenticated = false;
    });
  });