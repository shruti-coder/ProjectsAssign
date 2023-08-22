import * as action from "./action";

export const add_blog = (blog) => {
  return {
    type: action.ADD_BLOG,
    payload: blog,
  };
};

export const delete_blog = (id) => {
  return {
    type: action.DELETE_BLOG,
    payload: { id },
  };
};

export const update_blog = (blog) => {
  console.log(blog);
  return {
    type: action.UPDATE_BLOG,
    payload: blog,
  };
};

export const like_blog = (id, isLiked) => {
  return {
    type: action.LIKE_BLOG,
    payload: { id, isLiked },
  };
};
