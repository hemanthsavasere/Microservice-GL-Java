import React, { Component } from 'react';
import Item from './Item';

import { loadItems } from '../actions/items'
import { connect } from 'react-redux'

class ItemList extends Component {
  componentDidMount() {
    const { loadItems } = this.props;
    loadItems('food', 100)
  }
  renderItems() {
    const { items } = this.props;
    return items.map((item, idx) => {
      return (
        <div key={idx} className="list-group-item">
          <Item value={item} />
        </div>
      )
    })
  }
  render() {
    return (
      <div>
        {this.renderItems()}
      </div>
    );
  }
}

const mapStateToProps = state => {
  return {
    items: state.items
  }
}
const mapDispatchToProps = { loadItems }

export default connect(mapStateToProps, mapDispatchToProps)(ItemList);