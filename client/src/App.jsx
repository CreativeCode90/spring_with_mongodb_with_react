import React from 'react'
import { BrowserRouter ,Routes , Route } from 'react-router-dom'
import MyForm from './form/MyForm'
import Login from './form/Login'
import List from './list/List';
import Home from './Home';
import './App.css';
export default function App() {
  return (
   <BrowserRouter>
    <Routes>
        <Route path='/' element={<Home/>} />
        <Route path='/signup' element={<MyForm/>} />
        <Route path='/login' element={<Login/>} />
        <Route path='/list' element={<List/>}  />
    </Routes>
   </BrowserRouter>
  )
}

