--------------------------------------------------------
----------------------- CREATE -------------------------
--------------------------------------------------------
CREATE TABLE TIPO_DOCUMENTO (
	codigo	NUMERIC(2),
	nombre	VARCHAR(30)
);

CREATE TABLE ALUMNOS (
	identificacion		NUMERIC(25),
	tipo_documento		NUMERIC(2),
	nombre				VARCHAR(200),
	primer_apellido		VARCHAR(100),
	segundo_apellido	VARCHAR(100),
	fecha_nacimiento	DATE,
	telefono_fijo		NUMERIC(15),
	telefono_celular	NUMERIC(15)
);

CREATE TABLE PROFESORES (
	identificacion		NUMERIC(25),
	tipo_documento		NUMERIC(2),
	nombre				VARCHAR(200),
	primer_apellido		VARCHAR(100),
	segundo_apellido	VARCHAR(100),
	fecha_nacimiento	DATE,
	telefono_fijo		NUMERIC(15),
	telefono_celular	NUMERIC(15)
);

CREATE TABLE ASIGNATURAS (
	codigo		NUMERIC(10),
	nombre		VARCHAR(100),
	descripcion	VARCHAR(300)
);

CREATE TABLE ASIGNATURA_DESCRIPCION (
	codigo			NUMERIC(10),
	asignatura		NUMERIC(10),
	profesor		NUMERIC(25),
	profesor_doc	NUMERIC(2),
	estado			VARCHAR(3)
);

CREATE TABLE ASIGNATURA_HORARIOS (
	codigo					NUMERIC(20),
	asignatura_descripcion	NUMERIC(10),
	dia_semana				VARCHAR(3),
	hora_inicio				DATE,
	hora_final				DATE
);

CREATE TABLE ASIGNATURA_LOGROS (
	codigo					NUMERIC(20),
	asignatura_descripcion	NUMERIC(10),
	descripcion				VARCHAR(100),
	porcentaje				NUMERIC(3,2)
);

CREATE TABLE ASIGNATURA_ALUMNOS (
	codigo					NUMERIC(20),
	asignatura_descripcion	NUMERIC(10),
	alumno					NUMERIC(25),
	alumno_doc				NUMERIC(2)
);

CREATE TABLE ASIGNATURA_NOTAS (
	codigo		NUMERIC(20),
	alumno		NUMERIC(25),
	logro		NUMERIC(20),
	nota		NUMERIC(3,2)
);
--------------------------------------------------------
----------------------- ALERTER ------------------------
--------------------------------------------------------

-- Creacion de tabla "TIPO_DOCUMENTO"
ALTER TABLE TIPO_DOCUMENTO ADD CONSTRAINT pk_tipo_documento PRIMARY KEY (codigo);
ALTER TABLE TIPO_DOCUMENTO ADD CONSTRAINT nn_tipo_doc_nom CHECK(nombre IS NOT NULL);

-- Creacion de tabla "ALUMNOS"
ALTER TABLE ALUMNOS ADD CONSTRAINT pk_alumnos PRIMARY KEY (identificacion, tipo_documento);
ALTER TABLE ALUMNOS ADD CONSTRAINT nn_alum_nombre CHECK(nombre IS NOT NULL);
ALTER TABLE ALUMNOS ADD CONSTRAINT nn_alum_apellido CHECK(primer_apellido IS NOT NULL);
ALTER TABLE ALUMNOS ADD CONSTRAINT nn_alum_fec_nac CHECK(fecha_nacimiento IS NOT NULL);
ALTER TABLE ALUMNOS ADD CONSTRAINT fk_alum_tip_doc FOREIGN KEY (tipo_documento) REFERENCES TIPO_DOCUMENTO;

-- Creacion de tabla "PROFESORES"
ALTER TABLE PROFESORES ADD CONSTRAINT pk_profesor PRIMARY KEY (identificacion, tipo_documento);
ALTER TABLE PROFESORES ADD CONSTRAINT nn_alum_nombre CHECK(nombre IS NOT NULL);
ALTER TABLE PROFESORES ADD CONSTRAINT nn_alum_apellido CHECK(primer_apellido IS NOT NULL);
ALTER TABLE PROFESORES ADD CONSTRAINT nn_alum_fec_nac CHECK(fecha_nacimiento IS NOT NULL);
ALTER TABLE PROFESORES ADD CONSTRAINT fk_alum_tip_doc FOREIGN KEY (tipo_documento) REFERENCES TIPO_DOCUMENTO;

-- Creacion de tabla "ASIGNATURAS"
ALTER TABLE ASIGNATURAS ADD CONSTRAINT pk_asig PRIMARY KEY (codigo);
ALTER TABLE ASIGNATURAS ADD CONSTRAINT nn_asig_nombre CHECK(nombre IS NOT NULL);

-- Creacion de tabla "ASIGNATURA_DESCRIPCION"
ALTER TABLE ASIGNATURA_DESCRIPCION ADD CONSTRAINT pk_asig_des PRIMARY KEY (codigo);
ALTER TABLE ASIGNATURA_DESCRIPCION ADD CONSTRAINT fk_asig_des_asig FOREIGN KEY (asignatura) REFERENCES ASIGNATURAS;
ALTER TABLE ASIGNATURA_DESCRIPCION ADD CONSTRAINT fk_asig_des_prof FOREIGN KEY (profesor,profesor_doc) REFERENCES PROFESORES (identificacion, tipo_documento);
ALTER TABLE ASIGNATURA_DESCRIPCION ADD CONSTRAINT nn_asig_des_est CHECK(estado IS NOT NULL);

-- Creacion de tabla "ASIGNATURA_HORARIOS"
ALTER TABLE ASIGNATURA_HORARIOS ADD CONSTRAINT pk_asig_hor PRIMARY KEY (codigo);
ALTER TABLE ASIGNATURA_HORARIOS ADD CONSTRAINT fk_asig_hor_asig_d FOREIGN KEY (asignatura_descripcion) REFERENCES ASIGNATURA_DESCRIPCION;
ALTER TABLE ASIGNATURA_HORARIOS ADD CONSTRAINT nn_asig_hor_d_sem CHECK(dia_semana IS NOT NULL);
ALTER TABLE ASIGNATURA_HORARIOS ADD CONSTRAINT nn_asig_hor_h_ini CHECK(hora_inicio IS NOT NULL);
ALTER TABLE ASIGNATURA_HORARIOS ADD CONSTRAINT nn_asig_hor_h_fin CHECK(hora_final IS NOT NULL);

-- Creacion de tabla "ASIGNATURA_LOGROS"
ALTER TABLE ASIGNATURA_LOGROS ADD CONSTRAINT pk_asig_log PRIMARY KEY (codigo);
ALTER TABLE ASIGNATURA_LOGROS ADD CONSTRAINT fk_asig_log_asig_d FOREIGN KEY (asignatura_descripcion) REFERENCES ASIGNATURA_DESCRIPCION;
ALTER TABLE ASIGNATURA_LOGROS ADD CONSTRAINT nn_asig_log_des CHECK(descripcion IS NOT NULL);
ALTER TABLE ASIGNATURA_LOGROS ADD CONSTRAINT nn_asig_log_por CHECK(porcentaje IS NOT NULL);

-- Creacion de tabla "ASIGNATURA_ALUMNOS"
ALTER TABLE ASIGNATURA_ALUMNOS ADD CONSTRAINT pk_asig_alu PRIMARY KEY (codigo);
ALTER TABLE ASIGNATURA_ALUMNOS ADD CONSTRAINT fk_asig_alu_asig_d FOREIGN KEY (asignatura_descripcion) REFERENCES ASIGNATURA_DESCRIPCION;
ALTER TABLE ASIGNATURA_ALUMNOS ADD CONSTRAINT fk_asig_alu_alu FOREIGN KEY (alumno, alumno_doc) REFERENCES ALUMNOS  (identificacion, tipo_documento);

-- Creacion de tabla "ASIGNATURA_NOTAS"
ALTER TABLE ASIGNATURA_NOTAS ADD CONSTRAINT pk_asig_not PRIMARY KEY (codigo);
ALTER TABLE ASIGNATURA_NOTAS ADD CONSTRAINT fk_asig_not_asig_a FOREIGN KEY (alumno) REFERENCES ASIGNATURA_ALUMNOS;
ALTER TABLE ASIGNATURA_NOTAS ADD CONSTRAINT fk_asig_not_log FOREIGN KEY (logro) REFERENCES ASIGNATURA_LOGROS;
ALTER TABLE ASIGNATURA_NOTAS ADD CONSTRAINT nn_asig_not_not CHECK(nota IS NOT NULL);

--------------------------------------------------------
----------------------- SQUENCE ------------------------
--------------------------------------------------------

CREATE SEQUENCE seq_tipo_doc INCREMENT 1 MINVALUE 1 MAXVALUE 999999999999999999 START 1 CACHE 1;
CREATE SEQUENCE seq_asignatura INCREMENT 1 MINVALUE 1 MAXVALUE 999999999999999999 START 1 CACHE 1;
