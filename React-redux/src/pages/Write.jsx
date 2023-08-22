import { useState } from "react";
import "./write.css";
import { add_blog } from "../redux/actionlistner";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";

export default function Write() {
  const [data, setData] = useState({});
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const handleChange = (e) =>
    setData({ ...data, [e.target.name]: e.target.value });

  const submitForm = (e) => {
    e.preventDefault();
    console.log(data);
    dispatch(add_blog(data));
    navigate("/blogs");
  };

  return (
    <div className="write d-flex">
      <div className="col-50 bor">
        <img
          className=" writeImg"
          src="https://www.ghimprove.com/_blog/images/posts/hello-world/mountain.jpg"
          alt=""
        />
      </div>
      <div className="col-50 bor">
        <form className="writeForm">
          <div className="writeFormGroup">
            <div className="card">
              <input
                type="text"
                onChange={handleChange}
                name="title"
                placeholder="Title"
                className="writeInput"
                autoFocus={true}
              />
              <input
                type="text"
                onChange={handleChange}
                name="img"
                placeholder="Image URL"
                className="writeInput"
              />
              <input
                type="text"
                onChange={handleChange}
                name="category"
                placeholder="Category"
                className="writeInput"
              />
              <div className="writeFormGroup">
                <textarea
                  placeholder="Write Your Blog.."
                  onChange={handleChange}
                  name="body"
                  type="text"
                  className="writeInput writeText"
                ></textarea>
              </div>
              <div className="btn-div">
                <button onClick={submitForm} className="writeSubmit">
                  {" "}
                  Publish
                </button>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
  );
}
