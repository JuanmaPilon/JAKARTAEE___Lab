use tallerjava;
insert into peaje_Tag (idUnico) values ('A1');
insert into peaje_Tag (idUnico) values ('B1');
insert into peaje_Tag (idUnico) values ('C3');

insert into peaje_Vehiculo (tag_id, nacionalidad, tag_idUnico) values ( 1, 'NACIONAL','A1');
insert into peaje_Vehiculo (tag_id, nacionalidad, tag_idUnico) values ( 2, 'EXTRANJERO','B1');
insert into peaje_Vehiculo (tag_id, nacionalidad, tag_idUnico) values ( 3, 'EXTRANJERO','C3');
insert into peaje_vehiculoExtranjero (id) values (2);
insert into peaje_vehiculoExtranjero (id) values (3);

insert into peaje_Matricula (nroMatricula) values ('ASD-720');
insert into peaje_vehiculoNacional (id,matricula_id, nroMatricula) values (1, 1, 'ASD-720');

insert into peaje_tarifa (tipoTarifa, monto) values (1,180);
insert into peaje_tarifa (tipoTarifa, monto) values (2,100);

insert into gestion_cuenta (fechaApertura) values ('2024-05-29 10:34:14.533008');
insert into gestion_cuenta (fechaApertura) values ('2024-05-29 10:34:14.533009');
insert into gestion_cuentaPrePaga (saldo, nroCuenta) values (1000,1);

insert into gestion_Matricula (nroMatricula) values ('ASD-720');
insert into gestion_cuenta (fechaApertura) values ('2024-05-29 10:34:14.533008');
insert into gestion_cuenta (fechaApertura) values ('2024-05-29 10:34:14.533088');
insert into gestion_cuentaPrePaga (saldo, nroCuenta) values (5, 2);
insert into gestion_cuentaPrePaga (saldo, nroCuenta) values (5000, 3);

insert into gestion_tarjeta (nro, nombre, fechaVto) values (19, "BBVA", '2024-05-29 10:34:14.533008');

insert into gestion_cuentaPostPaga (saldo, nroCuenta, tarjeta_nro) values (3500, 3, 19);
insert into gestion_cuentaPostPaga (saldo, nroCuenta, tarjeta_nro) values (6500, 4, 19);
insert into gestion_clienteTelepeaje (ci, nombre, email, saldo, cuentaPostpaga_nroCuenta, cuentaPrepaga_nroCuenta, tarjeta_nro) values (48850556, 'El Nigga', 'nigga@mail.com', 80, 4, null, null );
insert into gestion_clienteTelepeaje (ci, nombre, email, saldo, cuentaPostpaga_nroCuenta, cuentaPrepaga_nroCuenta, tarjeta_nro) values (123456, 'numerito', 'numerito@gmail.com',1000, 3, 1, 19);
insert into gestion_clienteTelepeaje (ci, nombre, email, saldo, cuentaPostpaga_nroCuenta, cuentaPrepaga_nroCuenta, tarjeta_nro) values (234567, 'nom2', 'nom2@gmail.com',3000, 3, 2, 19);
insert into gestion_usuario (ci, email, nom, cliente_ci) values (234567, 'nom2@gmail.com', 'nom2', 234567);
insert into gestion_usuario (ci, email, nom, cliente_ci) values (48850556, 'nigga@mail.com', 'El Nigga', 48850556);
insert into gestion_usuario (ci, email, nom, cliente_ci) values (123456, 'numerito@gmail.com', 'numerito', 123456);
insert into gestion_Tag (idUnico) values ('A1');
insert into gestion_Tag (idUnico) values ('B1');
insert into gestion_Tag (idUnico) values ('C3');
insert into gestion_Vehiculo (nacionalidad,cliente_ci,tag_idUnico,tag_id) values (1,'123456','A1',1);
insert into gestion_Vehiculo (nacionalidad,cliente_ci,tag_idUnico,tag_id) values (1,'234567','B1',2);
insert into gestion_Vehiculo (nacionalidad,cliente_ci,tag_idUnico,tag_id) values (1,'48850556','C3',3);

insert into gestion_PasadaPorPeaje (costo, fecha, vehiculo_id) values (1.0, '2023-07-02', 1);
insert into gestion_PasadaPorPeaje (costo, fecha, vehiculo_id) values (2.0, '2023-07-03', 1);
insert into gestion_PasadaPorPeaje (costo, fecha, vehiculo_id) values (3.0, '2023-07-04', 1);
insert into gestion_PasadaPorPeaje (costo, fecha, vehiculo_id) values (4.0, '2023-07-02', 2);
insert into gestion_PasadaPorPeaje (costo, fecha, vehiculo_id) values (5.0, '2023-07-03', 2);
insert into gestion_PasadaPorPeaje (costo, fecha, vehiculo_id) values (6.0, '2023-07-04', 2);
insert into gestion_PasadaPorPeaje (costo, fecha, vehiculo_id) values (7.0, '2023-07-02', 3);
insert into gestion_PasadaPorPeaje (costo, fecha, vehiculo_id) values (8.0, '2023-07-03', 3);
insert into gestion_PasadaPorPeaje (costo, fecha, vehiculo_id) values (9.0, '2023-07-04', 3);