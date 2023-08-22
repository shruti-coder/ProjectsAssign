import "./post.css";
import React from "react";
import Posts from "../pages/Posts";
import { useSelector } from "react-redux";

export default function Post() {
  const data = useSelector((state) => state);
  return (
    <div className="post">
      {data.map((post) => (
        <Posts key={post.id} post={post} />
      ))}
    </div>
  );
}
