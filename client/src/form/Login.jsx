import React from "react";

export default function Login() {
  return (
    <div className="form_container">
      <form method="post">
        <div className="group">
          <p>Username </p>
          <input type="text" name="username" placeholder="Enter username" />
        </div>
        <div className="group">
          <p>Username </p>
          <input type="text" name="password" placeholder="Enter pass" />
        </div>
        <div className="btn">
          <button>Sign in</button>
        </div>
      </form>
    </div>
  );
}
