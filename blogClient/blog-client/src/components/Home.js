import React, { Component } from 'react';
import Header from './Header';


class Home extends Component {
  constructor(props) {
      super(props);
      this.state = {
        blogs: [],
        isLoading: true
      }
    }

    componentDidMount() {
      var myRequest = new Request('http://localhost:8080/api/blogs');

      fetch(myRequest)
      .then(response => response.json())
      .then(data => {
      this.setState({blogs: data})
      })

      this.setState({isLoading: false});
    }

  render(){
    if(this.state.isLoading) {
      return(
        <div>
        <Header />
        Loading...
        </div>
      );
    } else {
      return (
        <div>
        <Header />

        Home
        <div>
     <ul>
         {
             this.state.blogs.map((item, key) => {

                 return <li><a href={item.id}>{item.title}</a>: {item.content}</li>
             })
         }
     </ul>
 </div>
        </div>
      );
    }
  }
}

export default Home;
