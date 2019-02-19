import React from 'react';
import { Switch, Route, BrowserRouter } from 'react-router-dom';
import Home from './Home';
import Create from './Create';
import Blog from './Blog';

const Main = () => (
  <main>
    <BrowserRouter>
      <Switch>
        <Route exact path='/' component={Home}/>
        <Route path='/home' component={Home}/>
        <Route path='/create' component={Create}/>
        <Route path='/:id' component={Blog}/>
      </Switch>
    </BrowserRouter>

  </main>
)

export default Main;
