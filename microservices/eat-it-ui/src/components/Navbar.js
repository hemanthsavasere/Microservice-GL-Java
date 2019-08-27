
//--------------------------------------------------------------
// way-1 : class syntax
//--------------------------------------------------------------


import React, { PureComponent } from 'react';
import PropTypes from 'prop-types';

class Navbar extends PureComponent {
    render() {
        const { value } = this.props;
        return (
            <div>
                <nav className="navbar navbar-light bg-info">
                    <a className="navbar-brand" href="/">{value}</a>
                </nav>
            </div>
        );
    }
}

// Navbar.defaultProps = {
//     value: 'Unknown'
// }

Navbar.propTypes = {
    value: PropTypes.string.isRequired
}

export default Navbar;






//--------------------------------------------------------------
// way-2 : function syntax
//--------------------------------------------------------------

/*
import React from 'react';
import PropTypes from 'prop-types';


const Navbar = (props) => {
    console.log('Navbar :: render()')
    let { value } = props
    return (
        <div>
            <nav className="navbar navbar-light bg-info">
                <a className="navbar-brand" href="/">{value}</a>
            </nav>
        </div>
    );
};

Navbar.propTypes = {
    value: PropTypes.string.isRequired
}



export default Navbar;

*/