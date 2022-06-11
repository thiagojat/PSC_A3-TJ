-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 12-Jun-2022 às 00:26
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `escola`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `matricula` int(11) NOT NULL,
  `cpf` text NOT NULL,
  `nome` text NOT NULL,
  `endereco` text NOT NULL,
  `email` text NOT NULL,
  `celular` bigint(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`matricula`, `cpf`, `nome`, `endereco`, `email`, `celular`) VALUES
(1, '05289383042', 'Thiago Jose Avellaneda Techera', 'Estrada Jorge Pereira Nunes 61', 'techerajathiago@gmail.com', 9999999999),
(2, '00895185121', 'thiagooo', 'dtyfjdrytd', 'cghdfuytdu', 1896451);

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

CREATE TABLE `curso` (
  `cod_curso` int(11) NOT NULL,
  `cod_func_curso` int(11) NOT NULL,
  `cod_sala_curso` int(11) NOT NULL,
  `nome` text NOT NULL,
  `carga_horaria` int(11) NOT NULL,
  `desc_curso` text NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `curso`
--

INSERT INTO `curso` (`cod_curso`, `cod_func_curso`, `cod_sala_curso`, `nome`, `carga_horaria`, `desc_curso`, `status`) VALUES
(3, 2, 2, 'psc', 50, 'aasassasasasa', 0),
(4, 1, 2, 'psc', 50, 'aaaaaa', 1),
(5, 2, 2, 'psc', 50, 'aasassasasasa', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `cod_func` int(11) NOT NULL,
  `cpf` text NOT NULL,
  `nome` text NOT NULL,
  `endereco` text NOT NULL,
  `email` text NOT NULL,
  `celular` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`cod_func`, `cpf`, `nome`, `endereco`, `email`, `celular`) VALUES
(1, '05289383042', 'hericles', 'sulforte', 'sulfote@gamil.com', 51996092362),
(2, '12334567891', 'vitin cotta', 'perira neto 10', 'vitincotta@gmail.com', 51948792362),
(3, '12337851611', 'leonardo gal', 'diario de noticias 1615', 'golOgal@gmail.com', 51948462621);

-- --------------------------------------------------------

--
-- Estrutura da tabela `sala`
--

CREATE TABLE `sala` (
  `cod_sala` int(11) NOT NULL,
  `nome` text NOT NULL,
  `capacidade` int(11) NOT NULL,
  `lugar` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `sala`
--

INSERT INTO `sala` (`cod_sala`, `nome`, `capacidade`, `lugar`) VALUES
(1, '101', 50, 'Predio 1'),
(2, '102', 5, 'Predio 1');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`matricula`);

--
-- Índices para tabela `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`cod_curso`),
  ADD KEY `fk_cod_func_curso` (`cod_func_curso`),
  ADD KEY `fk_cod_sala_curso` (`cod_sala_curso`);

--
-- Índices para tabela `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`cod_func`);

--
-- Índices para tabela `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`cod_sala`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aluno`
--
ALTER TABLE `aluno`
  MODIFY `matricula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `curso`
--
ALTER TABLE `curso`
  MODIFY `cod_curso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `professor`
--
ALTER TABLE `professor`
  MODIFY `cod_func` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `sala`
--
ALTER TABLE `sala`
  MODIFY `cod_sala` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `curso`
--
ALTER TABLE `curso`
  ADD CONSTRAINT `fk_cod_func_curso` FOREIGN KEY (`cod_func_curso`) REFERENCES `professor` (`cod_func`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_cod_sala_curso` FOREIGN KEY (`cod_sala_curso`) REFERENCES `sala` (`cod_sala`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
