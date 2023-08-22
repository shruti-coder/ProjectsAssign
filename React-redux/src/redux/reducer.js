import * as actions from "./action";
let id = 0;

export const reducer = (state = [], action) => {
  switch (action.type) {
    case actions.ADD_BLOG:
      action.payload.id = ++id;
      action.payload.isLiked=false;
      return [...state, action.payload];
    case actions.DELETE_BLOG:
      return state.filter((blog) => blog.id !== action.payload.id);
    case actions.UPDATE_BLOG:
      const index = state.findIndex((obj) => obj.id === action.payload.id);
      console.log(index);
      state[index] = {
        ...state[index],
        ...action.payload,
      };
      return state;
      case actions.LIKE_BLOG:
        const ind = state.findIndex((obj) => obj.id === action.payload.id);
        state[ind]={...state[ind],isLiked:action.payload.isLiked}
    default:
      return state;
  }
};
