import React, { useEffect, useState } from 'react'
import axios from 'axios'
function Home() {
    const [data , setData] = useState("");
    useEffect(()=>{
        axios.get("http://localhost:8080/app/welcome")
        .then((res)=>setData(res.data))
        .catch((e)=>console.log("not find ",e))
    },[data])
  return (
    <div>
      {data}
    </div>
  )
}

export default Home
