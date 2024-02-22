import React, {useLayoutEffect, useState} from "react";
import {getCurrency} from "../Utilis";


const Services = () => {
    const [services, setServices] = useState([]);
    useLayoutEffect(() => {
        const getServices = async () => {
            const res = await fetch("/api/services")
            const services = await res.json();
            setServices(services)
        }
        getServices().catch(err => console.log("error fetching services: " + err))
    }, []);

    return (
        <>
        <table>
        <thead>
        <th>ID</th>
        <th>Service Name</th>
        <th>Service Price</th>
        </thead>
        <tbody>
        {services.map(service => {
                const {serviceId, serviceName, servicePrice} = service;
                return (
                    <tr key={serviceId}>
                        <td>{serviceId}</td>
                        <td>{serviceName}</td>
                        <td>{getCurrency(servicePrice)}</td>
                    </tr>
                )
            }
        )}
        </tbody>
        </table>
</>
)
};

export default Services;

