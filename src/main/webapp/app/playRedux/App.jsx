import React, { Component, PropTypes } from 'react';
import { Row } from 'react-bootstrap';
import { connect } from 'react-redux';
import { insertPost, deletePost, updatePost, selectPost } from './actions';
import { Post, PostList } from './components';

class App extends Component {
  componentDidMount() {
    const { dispatch } = this.props;
    dispatch(selectPost());
  }
  render() {
    const { posts, dispatch } = this.props;
    console.log(posts);
    return (
      <Row>
        <PostList posts={posts} />
        <Post
          insertFunc={post => dispatch(insertPost(post))}
          deleteFunc={post => dispatch(deletePost(post))}
          updateFunc={post => dispatch(updatePost(post))}
        />
      </Row>
    );
  }
}

App.propTypes = {
  dispatch: PropTypes.func.isRequired,
  posts: PropTypes.array.isRequired,
};


const getInitialState = state => ({ posts: state.posts });


export default connect(getInitialState)(App);
