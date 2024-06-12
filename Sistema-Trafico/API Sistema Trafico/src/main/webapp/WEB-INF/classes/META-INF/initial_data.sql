use tallerjava;
insert into peaje_Tag (idUnico) values ('A1');
insert into peaje_Tag (idUnico) values ('B1');
insert into gestion_Tag (idUnico) values ('C3');
insert into peaje_Vehiculo (tag_id, nacionalidad, tag_idUnico) values ('A1', 1, 1);
insert into peaje_Vehiculo (tag_id, nacionalidad, tag_idUnico) values ('B1', 2, 2);

insert into peaje_tarifa (tipoTarifa, monto) values (1,180);
insert into peaje_tarifa (tipoTarifa, monto) values (2,100);

insert into gestion_cuenta (fechaApertura) values ('2024-05-29 10:34:14.533008');
insert into gestion_cuenta (fechaApertura) values ('2024-05-29 10:34:14.533009');
insert into gestion_cuentaPrePaga (saldo, nroCuenta) values (1000,1);


insert into gestion_cuenta (fechaApertura) values ('2024-05-29 10:34:14.533008');
insert into gestion_cuentaPrePaga (saldo, nroCuenta) values (1500, 2);
insert into gestion_cuentaPrePaga (saldo, nroCuenta) values (5000, 3);
insert into gestion_tarjeta (nro, nombre, fechaVto) values (19, "BBVA", '2024-05-29 10:34:14.533008');
insert into gestion_cuentaPostPaga (saldo, nroCuenta, tarjeta_nro) values (3500, 3, 19);
insert into gestion_clienteTelepeaje (ci, nombre, email, saldo, cuentaPostpaga_nroCuenta, cuentaPrepaga_nroCuenta, tarjeta_nro) values (48850556, 'El Nigga', 'nigga@mail.com', 20, null, null, null );
insert into gestion_clienteTelepeaje (ci, nombre, email, saldo, cuentaPostpaga_nroCuenta, cuentaPrepaga_nroCuenta, tarjeta_nro) values (123456, 'numerito', 'numerito@gmail.com',1000, 3, 1, null);
insert into gestion_usuario (ci, email, nom, cliente_ci) values (234567, 'nom2@gmail.com', 'nom2', null);
insert into gestion_usuario (ci, email, nom, cliente_ci) values (123456, 'numerito@gmail.com', 'numerito', 123456);

insert into gestion_Vehiculo (nacionalidad,cliente_ci,tag_idUnico,tag_id) values (1,'123456',1,'C3');
