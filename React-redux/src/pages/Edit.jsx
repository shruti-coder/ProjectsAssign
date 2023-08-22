import { update_blog } from "../redux/actionlistner";
import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
const Edit = () => {
  const [post, setPost] = useState();
  const params = useParams();
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const state = useSelector((state) => state);
  useEffect(() => {
    const blog = state.filter((b) => b.id === Number(params.id));
    setPost(blog[0]);
  }, [params.id]);
  const handleChange = (e) => {
    setPost({ ...post, [e.target.name]: e.target.value });
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    dispatch(update_blog(post));
    navigate("/blogs");
    console.log(post);
  };
  return (
    <>
      <div className="conatiner-fluid">
        <div className="row">
          <div className="col-md-7 m-auto">
            <form>
              <div class="mb-3">
                <label class="form-label">Title</label>
                <input
                  type="text"
                  className="form-control"
                  name="title"
                  value={post?.title}
                  onChange={handleChange}
                />
              </div>
              <div class="mb-3">
                <label class="form-label">Image</label>
                <input
                  type="text"
                  className="form-control"
                  name="img"
                  value={post?.img}
                  onChange={handleChange}
                />
              </div>
              <div class="mb-3">
                <label class="form-label">Category</label>
                <input
                  type="text"
                  className="form-control"
                  name="category"
                  value={post?.category}
                  onChange={handleChange}
                />
              </div>
              <div class="form-floating">
                <label>Textarea</label>
                <textarea
                  class="form-control"
                  placeholder="Write Your Blog"
                  name="body"
                  value={post?.body}
                  onChange={handleChange}
                ></textarea>
              </div>
              <button
                type="submit"
                className="btn btn-primary"
                onClick={handleSubmit}
              >
                Submit
              </button>
            </form>
          </div>
        </div>
      </div>
    </>
  );
};
export default Edit;
