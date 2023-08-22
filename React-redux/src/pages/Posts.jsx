import { useNavigate } from "react-router-dom";
import "./posts.css";
export default function Posts(props) {
  const {id, img, title, category, body } = props.post;
  const navigate= useNavigate();
  return (
    <div className="posts border" onClick={()=>{navigate(`/blogs/${id}`)}}>
      <img className="postsImg" src={img} alt="" />
      <div className="postsInfo">
        <div className="postsCats">
          <span className="postsCat">{category}</span>
        </div>
        <span className="postsTitle">{title}</span>
        <hr />
      </div>
      <p className="postsDesc">{body}</p>
    </div>
  );
}
