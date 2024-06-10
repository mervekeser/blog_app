import React, { useEffect, useState } from "react";
import { BrowserRouter, Route, Router, Routes } from "react-router-dom";
import Login from "../../pages/Auth/Login/Login";
import Signup from "../../pages/Auth/SignUp/SignUp";
import UserPanel from "../../pages/User/UserPanel";
import UserInfo from "../../pages/User/UserInfo";
import PrivateRoutes from "../../core/utils/PrivateRoutes/PrivateRoutes";

import { useDispatch, useSelector } from "react-redux";
import { MyJwtPayload } from "../../models/jwt/MyJwtPayload";
import { jwtDecode } from "jwt-decode";

import { AppDispatch } from "../../store/store";
import { userInfo } from "../../store/slices/userSlice";
import HomePage from "../../pages/Home/HomePage";
import UserPosts from "../Post/UserPosts";

const Dashboard = () => {
  const userState = useSelector((state: any) => state.user);
  const dispatch = useDispatch<AppDispatch>();
  const [decode, setDecode] = useState<MyJwtPayload>();

  useEffect(() => {
    let token: string | null = localStorage.getItem("jsonwebtoken");
    if (token) {
      const jwtDecoded = jwtDecode(token) as MyJwtPayload;
      setDecode(jwtDecoded);
      dispatch(userInfo(jwtDecoded.email || ""));
    }
  }, []);

  console.log(userState);

  return (
    <>
      <Routes>
        <Route path="/" element={<HomePage/>}></Route>
        <Route path="/login" element={<Login />}></Route>
        <Route path="/signup" element={<Signup />}></Route>
        <Route path="/profile/posts" element={<UserPosts/>}/>
        <Route element={<PrivateRoutes />}>
          <Route path="/profile" element={<UserPanel />}>
            <Route index element={<UserInfo />} />
            
          </Route>
        </Route>

        <Route path="*" element={<div>Not found</div>}></Route>
      </Routes>
    </>
  );
};

export default Dashboard;
