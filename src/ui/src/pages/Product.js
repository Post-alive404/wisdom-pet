import React, {useLayoutEffect, useState} from "react";
import {getCurrency} from "../Utilis";

const Product = () => {
    const [products, setProducts] = useState([])
    const [vendors, setVendors] = useState(new Map())

    const add = (key, value) => {
        setVendors(prev => new Map([...prev, [key, value]]))
    }
    useLayoutEffect(() => {
        const getProducts = async () => {
            const res = await fetch("/api/products")
            const products = await res.json()
            setProducts(products)
        }
        const getVendors = async () =>{
            const res = await fetch("/api/vendors")
            const vendors = await res.json()
            vendors.map(vendor => {
                const {vendorId,
                    vendorName,
                    vendorContact,
                    vendorPhone,
                    vendorEmail,
                    vendorAddress} = vendor;
                add(vendorId, vendor)
            })
        }

        getProducts().catch(err => console.log("error fetching products: " + err))
        getVendors().catch(err => console.log("error fetching vendors: " + err))
    }, []);
    return (
        <>
            <table>
                <thead>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Product Price</th>
                <th>Vendor</th>
                </thead>
                <tbody>
                {products.map(product => {
                        const {productId, productName, productPrice, vendorId} = product;
                        return (
                            <tr key={productId}>
                                <td>{productId}</td>
                                <td>{productName}</td>
                                <td>{getCurrency(productPrice)}</td>
                                <td>{vendors.get(vendorId).vendorName}</td>
                            </tr>
                        )
                    }
                )}
                </tbody>
            </table>
        </>
    )
};

export default Product;