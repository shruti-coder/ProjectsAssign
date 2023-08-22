import React from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
// import'bootstrap/dist/css/bootstrap-theme.css';
// import'bootstrap/dist/css/bootstrap.css';
import {
  BrowserRouter as Router,
  Route,
  Link,
  Switch,
  Routes,
} from "react-router-dom";
import Header from "./Components/Header";
import Home from "./pages/Home";
import Post from "./Components/Post";
import Single from "./Components/Single";
import Write from "./pages/Write";
import { store } from "./redux/store";
import { Provider } from "react-redux";
import Edit from "./pages/Edit";

const App = () => {
  return (
    <Provider store={store}>
      <Router>
        <Header />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/blogs" element={<Post />} />
          <Route path="/blogs/:id" element={<Single />} />
          <Route path="/write" element={<Write />} />
          <Route path="/edit/:id" element={<Edit />} />

        </Routes>
      </Router>
    </Provider>
  );
};
export default App;
