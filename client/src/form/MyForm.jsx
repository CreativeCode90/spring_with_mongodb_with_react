import React, { useState } from "react";
import axios from "axios";

export default function MyForm() {
  const [show, setShow] = useState(false);
  const HundleSumit = async (e) => {
    e.preventDefault();
    const form = new FormData(e.target);
    const obj = Object.fromEntries(form);
    try {
      await axios
        .post("http://localhost:8080/app/create", obj)
        .then((res) => {
          console.log(res.data);
          setShow(true);
          if (show) {
            setTimeout(() => {
              setShow(false);
            }, 2000);
          }
        })
        .catch((e) => console.log("error ", e));
    } catch (e) {
      console.log("somthing went wrong ", e);
    }
  };
  return (
    <>
      <h3 className={show ? "alert" : "hide"}>entry is add</h3>
      <div className="form_container">
        <form method="post" onSubmit={HundleSumit}>
          <div className="group">
            <p>Username </p>
            <input type="text" name="username" placeholder="Enter username" />
          </div>
          <div className="group">
            <p>Email </p>
            <input type="text" name="email" placeholder="Enter email" />
          </div>
          <div className="group">
            <p>Password </p>
            <input type="text" name="password" placeholder="Enter pass" />
          </div>
          <div className="btn">
            <button>Sign up</button>
          </div>
        </form>
      </div>
    </>
  );
}
