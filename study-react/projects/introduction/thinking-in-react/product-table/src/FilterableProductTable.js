import React, { Component } from 'react'

class SearchBar extends Component {
    constructor(props) {
        super(props);
        this.handleFilterTextChange=this.handleFilterTextChange.bind(this);
        this.handleInStockChange=this.handleInStockChange.bind(this);
    }

    handleFilterTextChange(e) {
        this.props.onFilterTextChange(e.target.value)
    }

    handleInStockChange(e) {
        this.props.onInStockChange(e.target.checked)
    }

    render() {
        const { filterText, inStockOnly } = this.props;
        return (
            <form>
                <input
                    type="text"
                    value={filterText}
                    placeholder="Search ..."
                    onChange={this.handleFilterTextChange}
                />
                <p>
                    <input 
                        type="checkbox" 
                        checked={inStockOnly}
                        onChange={this.handleInStockChange}
                    />
                    {' '}
                    Only show products in stock
                </p>
            </form>
        )
    }
}

class ProductTable extends Component {

    render() {
        const { products, filterText, inStockOnly } = this.props;
        const rows = [];
        let lastCategoryName = null;
        products.forEach((product) => {
            if(product.name.indexOf(filterText) === -1){
                return;
            }
            if(inStockOnly && !product.stocked){
                return;
            }
            if (product.category !== lastCategoryName) {
                rows.push(
                    <ProductCategoryRow
                        category={product.category}
                        key={product.category} />
                );
            }
            rows.push(
                <ProductRow
                    product={product}
                    key={product.name}
                />
            );
            lastCategoryName = product.category;
        });

        return (
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    {rows}
                </tbody>
            </table>
        )
    }
}

class ProductCategoryRow extends Component {

    render() {
        const { category } = this.props;
        return (
            <tr>
                <th colSpan="2">{category}</th>
            </tr>
        )
    }
}

class ProductRow extends Component {

    render() {
        const { product } = this.props;
        const name = product.stocked ? product.name : <span style={{ color: "red" }}>{product.name}</span>;
        return (
            <tr>
                <td>{name}</td>
                <td>{product.price}</td>
            </tr>
        )
    }
}

class FilterableProductTable extends Component {
    constructor(props) {
        super(props);
        this.state = {
            filterText: '',
            inStockOnly: false
        };
        this.handleFilterTextChange = this.handleFilterTextChange.bind(this);
        this.handleInStockChange = this.handleInStockChange.bind(this);
    }

    handleFilterTextChange(filterText) {
        this.setState({
            filterText: filterText
        })
    }

    handleInStockChange(inStockOnly) {
        this.setState({
            inStockOnly: inStockOnly
        })
    }

    render() {
        const { products } = this.props;
        const { filterText, inStockOnly } = this.state;
        return (
            <div>
                <SearchBar
                    filterText={filterText}
                    inStockOnly={inStockOnly}
                    onFilterTextChange={this.handleFilterTextChange}
                    onInStockChange={this.handleInStockChange}
                />
                <ProductTable products={products}
                    filterText={filterText}
                    inStockOnly={inStockOnly}
                />
            </div>
        )
    }

}

export default FilterableProductTable;