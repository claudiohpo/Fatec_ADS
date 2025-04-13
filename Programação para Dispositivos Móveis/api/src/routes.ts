//Define as rotas da API.

import { Router} from "express";
import { CreateUserController } from "./controller/user/CreateUserController";
import { ListUsersController } from "./controller/user/ListUsersController";
import { UpdateUserController } from "./controller/user/UpdateUserController";
import { DeleteUserController } from "./controller/user/DeleteUserController";

import { AuthenticateUserController } from "./controller/Authenticate/AuthenticateUserController";

import { CreateCategoryController } from "./controller/category/CreateCategoryController";
import { DeleteCategoryController } from "./controller/category/DeleteCategoryController";
import { UpdateCategoryController } from "./controller/category/UpdateCategoryController";
import { ListCategoryController } from "./controller/category/ListCategoryController";

import { CreateProductController } from "./controller/product/CreateProductController";
import { ListProductController } from "./controller/product/ListProductController"; 
import { UpdateProductController } from "./controller/product/UpdateProductController";
import { DeleteProductController } from "./controller/product/DeleteProductController";

import { CreateSaleController } from "./controller/sale/CreateSaleController";
import { ListSaleController } from "./controller/sale/ListSaleController";
import { UpdateSaleController } from "./controller/sale/UpdateSaleController";
import { DeleteSaleController } from "./controller/sale/DeleteSaleController";

import { CreateClientController } from "./controller/client/CreateClientController";
import { ListClientController } from "./controller/client/ListClientController";
import { UpdateClientController } from "./controller/client/UpdateClientController";
import { DeleteClientController } from "./controller/client/DeleteClientController";
import { ensureAuthenticated } from "./middleware/ensureAuthenticated";

import { CreateSupplierController } from "./controller/supplier/CreateSupplierController";
import { ListSupplierController } from "./controller/supplier/ListSupplierController";
import { UpdateSupplierController } from "./controller/supplier/UpdateSupplierController"; 
import { DeleteSupplierController } from "./controller/supplier/DeleteSupplierController";


const createUserController = new CreateUserController();
const listUsersController = new ListUsersController();
const updateUserController = new UpdateUserController();
const deleteUserController = new DeleteUserController();

const authenticateUserController = new AuthenticateUserController();

const createCategoryController = new CreateCategoryController();
const deleteCategoryController = new DeleteCategoryController();
const updateCategoryController = new UpdateCategoryController();
const listCategoryController = new ListCategoryController();

const createProductController = new CreateProductController();
const listProductController = new ListProductController();
const updateProductController = new UpdateProductController();
const deleteProductController = new DeleteProductController();

const createSaleController = new CreateSaleController();
const listSaleController = new ListSaleController();
const updateSaleController = new UpdateSaleController();
const deleteSaleController = new DeleteSaleController();

const createClientController = new CreateClientController();
const listClientController = new ListClientController();
const updateClientController = new UpdateClientController();
const deleteClientController = new DeleteClientController();

const createSupplierController = new CreateSupplierController();
const listSupplierController = new ListSupplierController();
const updateSupplierController = new UpdateSupplierController();
const deleteSupplierController = new DeleteSupplierController();

const router = Router();
router.post("/login", authenticateUserController.handle);

// Define a rota POST /users que chama o método handle do controlador
router.post("/users", createUserController.handle.bind(createUserController)); //bind é usado para garantir que o this dentro do método handle aponte para a instância correta do controlador
router.get("/users", listUsersController.handle);
router.put("/users/:id", updateUserController.handle);
router.delete("/users/:id", deleteUserController.handle);

router.post("/category", createCategoryController.handle.bind(createCategoryController));
router.get("/category", listCategoryController.handle);
router.put("/category/:id", updateCategoryController.handle);
router.delete("/category/:id", deleteCategoryController.handle);

router.post("/product", createProductController.handle.bind(createProductController));
router.get("/product", listProductController.handle);   
router.put("/product/:id", updateProductController.handle);
router.delete("/product/:id", deleteProductController.handle);

router.post("/sale", createSaleController.handle.bind(createSaleController));
router.get("/sale", listSaleController.handle);
router.put("/sale/:id", updateSaleController.handle);
router.delete("/sale/:id", deleteSaleController.handle);

router.post("/client", createClientController.handle.bind(createClientController));
router.get("/client", listClientController.handle);
router.put("/client/:id", updateClientController.handle);
router.delete("/client/:id", deleteClientController.handle);

router.post("/supplier", createSupplierController.handle.bind(createSupplierController));
router.get("/supplier", listSupplierController.handle);
router.put("/supplier/:id", updateSupplierController.handle);
router.delete("/supplier/:id", deleteSupplierController.handle);

router.use(ensureAuthenticated); //ativa Autenticação para as rotas abaixo

export {router};