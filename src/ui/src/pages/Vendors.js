import React, {useLayoutEffect, useState} from "react";


const Vendors = () => {
  const [vendors, setVendors] = useState([]);
    useLayoutEffect(() => {
        const getVendors = async () => {
            const res = await fetch("/api/vendors")
            const vendors = await res.json();
            setVendors(vendors);
        }

        getVendors().catch(err => console.log("error fetching vendors: " + err))
    }, []);

    return(
        <>
            <table>
                <thead>
                <th>Vendor Id</th>
                <th>Vendor Name</th>
                <th>Contact</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                </thead>
                <tbody>
                {vendors.map(vendor => {
                        const {vendorId, vendorName, vendorContact, vendorPhone, vendorEmail, vendorAddress} = vendor;
                        return (
                            <tr key={vendorId}>
                                <td>{vendorId}</td>
                                <td>{vendorName}</td>
                                <td>{vendorContact}</td>
                                <td>{vendorPhone}</td>
                                <td>{vendorEmail}</td>
                                <td>{vendorAddress}</td>
                            </tr>
                        )
                    }
                )}
                </tbody>
            </table>
        </>
    )
};

export default Vendors;