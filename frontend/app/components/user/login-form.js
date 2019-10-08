import Component from "@ember/component";

function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

export default Component.extend({
  useLinks: true,
  onLogin: null,
  onCreateAccount: null,

  email: null,
  password: null,

  hasError: null,
  errorMessage: null,

  actions: {
    onLogin() {
      const promiseResult = this.get("onLogin")(
        this.get("email"),
        this.get("password")
      );

      if (promiseResult) {
        promiseResult.then(result => {
          if (result && result.hasError && !validateEmail(email.value)) {
            this.set("hasError", true);
            this.set("errorMessage", "Email not valid");
          } else {
            this.set("hasError", false);
            this.set("errorMessage", null);
          }
        });
      }
    },

    onCreateAccount() {
      this.get("onCreateAccount")();
    }
  }
});
