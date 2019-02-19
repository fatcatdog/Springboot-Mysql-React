import React, { Component } from 'react';
import Header from './Header';

class Blog extends Component {
  constructor(props) {
      super(props);
      this.state = {
        blog: null,
        isLoading: true
      }
    }

    componentDidMount() {
      var num = (this.props.location.pathname.replace(/[^0-9]/g,''));

      var blogRequest = new Request('http://localhost:8080//api/blogs/' + num);

      fetch(blogRequest)
      .then(response => response.json())
      .then(data => {
      this.setState({blog: data, isLoading: false})
      })


    }

render(){
if(this.state.isLoading) {
return(
<div>
<Header />
Loading Blog...
</div>
);
} else {
return (
<div>
<Header />

Title:
<br />
<br />
{this.state.blog.title}
<br />
<br />
Content:
<br />
<br />
{this.state.blog.content}
</div>
);
}
}
}
export default Blog;
