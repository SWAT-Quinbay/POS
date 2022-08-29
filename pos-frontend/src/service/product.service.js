import axios from "axios";
import { baseInventoryUrl } from "@/utils/urls"

export const addNewProduct = ({ productData , successCallback ,  errrorCallback}) => {
  axios
    .post(`${baseInventoryUrl}/add` , productData)
    .then((response) => {
      successCallback && successCallback(response);
    })
    .catch((e) => {
      errrorCallback && errrorCallback(e);
    });
}

export const updateProductDetail = ({ productData , successCallback ,  errrorCallback}) => {
    axios
      .put(`${baseInventoryUrl}`,productData)
      .then((response) => {
        successCallback && successCallback(response);
      })
      .catch((e) => {
        errrorCallback && errrorCallback(e);
      });
  }

  export const deleteProductData = ({ productId , successCallback ,  errrorCallback}) => {
    axios
      .delete(`${baseInventoryUrl}/${productId}`)
      .then((response) => {
        successCallback && successCallback(response);
      })
      .catch((e) => {
        errrorCallback && errrorCallback(e);
      });
  }

  export const getProductByName = ({ searchKey, successCallback, errorCallback }) => {
    axios
      .get(`${baseInventoryUrl}/search?name=${searchKey}&page=0&size=20`)
      .then((response) => {
        successCallback && successCallback(response);
      })
      .catch((e) => {
        errorCallback && errorCallback(e);
      });
  }

export const getInventory = ({ successCallback, errrorCallback }) => {
  axios
    .get(`${baseInventoryUrl}/all?page=0&size=100`)
    .then((response) => {
      successCallback && successCallback(response);
    })
    .catch((e) => {
      errrorCallback && errrorCallback(e);
    });
}


