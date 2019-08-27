import React, { Component } from 'react';

class ReviewForm extends Component {
    state = {
        isOpen: false,
        author: 'Nag@mail.com',
        rating: 5,
        body: ''
    }
    toggleForm() {
        const { isOpen } = this.state;
        this.setState({ isOpen: !isOpen });
    }
    handleForm(e) {
        e.preventDefault();
        const { author, rating, body } = this.state;
        let formData = {
            author, rating, body
        }
        const { onSubmit } = this.props;
        if (onSubmit) {
            onSubmit({ review: formData });
            this.toggleForm()
        }
    }
    handleChange(e) {
        let { id, value } = e.target
        this.setState({ [id]: value });
    }
    renderForm() {
        const { isOpen, author, rating, body } = this.state;
        if (!isOpen)
            return <button onClick={e => this.toggleForm()} className="btn btn-sm btn-dark"><i className="fa fa-plus"></i></button>
        else return (
            <div className="">
                <div className="card">
                    <div className="card-header">Review Form</div>
                    <div className="card-body">
                        <form onSubmit={e => this.handleForm(e)}>
                            <div className="form-group">
                                <label>author</label>
                                <input className="form-control" id="author" value={author} onChange={e => this.handleChange(e)} />
                            </div>
                            <div className="form-group">
                                <label>rating</label>
                                <select className="form-control" id="stars" value={rating} onChange={e => this.handleChange(e)}>
                                    {[1, 2, 3, 4, 5].map(n => <option key={n}>{n}</option>)}
                                </select>
                                {rating < 3 ? "expected at-least 3 rating" : ''}
                            </div>
                            <div className="form-group">
                                <label>body</label>
                                <textarea className="form-control" id="body" value={body} onChange={e => this.handleChange(e)}></textarea>
                            </div>
                            <button className="btn btn-sm btn-dark">submit</button>
                            &nbsp;<button onClick={e => this.toggleForm()} type="button" className="btn btn-sm btn-danger">cancel</button>
                        </form>
                    </div>
                </div>
            </div>
        )
    }
    render() {
        return (
            <div className="row">
                <div className="col-8 col-sm-8 col-md-6">
                    {this.renderForm()}
                </div>
            </div>
        );
    }
}

export default ReviewForm;