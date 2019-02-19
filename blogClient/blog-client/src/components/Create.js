import React, { Component } from 'react';
import Header from './Header';
class Create extends Component {

  emptyBlog = {
    title: '',
    content: ''
  };

  constructor(props) {
      super(props);
      this.state = {
        item: this.emptyBlog
     };
     this.handleChange = this.handleChange.bind(this);
     this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
       const target = event.target;
       const value = target.value;
       const name = target.name;
       let item = {...this.state.item};
       item[name] = value;
       this.setState({item});
     }

     async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;

        await fetch('http://localhost:8080/api/blogs', {
          method: 'POST',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(item)
        }).then(function(response) {
        if (!response.ok) {
            throw Error(response.statusText);
        }
        return response;
    }).then(window.location.assign("http://localhost:3000"))
      }

    render() {
      const {item} = this.state;
      return (
        <div>
        <Header />
        <form onSubmit={this.handleSubmit}>
        Title:
          <input type="text" name="title" id="title" value={item.title}
          onChange={this.handleChange}
          />
        Content:
          <input type="text" name="content" id="content" value={item.content}
          onChange={this.handleChange}
          />
          <input type="submit" value="Submit" />
       </form>
       </div>
      );
   }
}
export default Create;
