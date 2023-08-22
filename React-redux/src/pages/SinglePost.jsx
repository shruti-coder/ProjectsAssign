import "./singlepost.css";
import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { useSelector,useDispatch } from "react-redux";
import { delete_blog, like_blog } from "../redux/actionlistner";
const SinglePost = () => {
  const[like,setLike]=useState(false);
  const [data, setData] = useState({});
  const blogs = useSelector((state) => state);
  const params = useParams();
  useEffect(() => {
    console.log(params.id);
    const post = blogs.filter((b) => b.id === Number(params.id));
    setData(post[0]);
  }, [params.id,like]);
  const navigate = useNavigate();
  const dispatch=useDispatch();
  const handleDelete = () => {
    dispatch(delete_blog(data.id));
    navigate("/blogs");
  }
  const handleLiked=()=>{
    dispatch(like_blog(data.id,!data.isLiked));
    setLike(!like);
  };
  return (
    <div className="singlePost">
      <div className="singlePostWrapper">
        <img src={data.img} alt="" className="singlePostImg" />
        <h1 className="singlePostTitle">
          {data.title}
          <div className="singlePostEdit">
            <i
              className=" singlePostIcon fa-solid fa-pen-to-square"
              onClick={() => {
                navigate(`/edit/${data.id}`);
              }}
            ></i>
            <i
              className="singlePostIcon fa-solid fa-trash"
              onClick={handleDelete}
            ></i>
          </div>
        </h1>
        <div className="singlePostInfo">
          <span className="singlePostAuthor">
            Category: <b>{data.category}</b>
          </span>
          <i className={data.isLiked?" singlePostIcon fa-solid fa-heart":" singlePostIcon fa-regular fa-heart"} onClick={handleLiked}></i>
        </div>
        <p className="singlePostDesc">{data.body}</p>
      </div>
    </div>
  );
};

export default SinglePost;
