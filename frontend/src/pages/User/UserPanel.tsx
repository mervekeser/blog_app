import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import UserInfo from "./UserInfo";
import UserPosts from "../../components/Post/UserPosts";

type Props = {};

function UserPanel({}: Props) {
  const [activeTab, setActiveTab] = useState("profile");
  const location = useLocation();

  useEffect(() => {
    const currentPath: string | undefined = location.pathname.split("/").pop();
    setActiveTab(currentPath!);
  }, [location]);

  return (
    <div className="container mx-auto ">
      <div className="md:grid md:grid-cols-12 min-h-screen text-black bg-white ">
        
        <div className="col-span-12 p-6 text-medium text-gray-500 dark:text-gray-400 dark:bg-gray-800 bg-white">
          {activeTab === "profile" && <UserInfo />}
          {activeTab === "profile/posts" && <UserPosts />}
        </div>
      </div>
    </div>
  );
}

export default UserPanel;
