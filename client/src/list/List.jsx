import React, { useState, useEffect } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
function List() {
  const [data, setData] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/app/get") // Replace with your backend URL
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => console.error("Error fetching data:", error));
  }, []);

  const delete_user = async (e) => {
    try {
      (await axios.delete(`http://localhost:8080/app/delete/${e}`))
        .then((e) => {
          console.log("delete user");
        })
        .catch((e) => console.log("error", e));
    } catch (e) {
      console.log("somthing went wroung", e);
    }
  };

  console.log(data);
  return (
    <div className="list_container">
      <div className="intro">
        <h1>User Entries</h1>
        <div className="info">
          <Link to="/signup">
            <button className="add">add new</button>
          </Link>
        </div>
      </div>
      {data.length > 0 ? (
        <table>
          <tr>
            <th>id</th>
            <th>username</th>
            <th>email</th>
            <th>password</th>
            <th>edit</th>
          </tr>

          {data.map((item) => (
            <>
              <tbody>
                <td className="td">{item.id}</td>
                <td className="td">{item.username}</td>
                <td className="td">{item.email}</td>
                <td className="td">{item.password}</td>
                <td className="edit">
                  <Link to={`/update/${item._id}`}>
                    <button className="up">update</button>
                  </Link>
                  <button className="del" onClick={() => delete_user(item.id)}>
                    delete
                  </button>
                  <button className="for">change pass</button>
                </td>
              </tbody>
            </>
          ))}
        </table>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
}

export default List;
