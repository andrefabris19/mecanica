-- phpMyAdmin SQL Dump
-- version 4.6.6deb5ubuntu0.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Aug 05, 2021 at 07:59 PM
-- Server version: 5.7.34-0ubuntu0.18.04.1
-- PHP Version: 7.2.24-0ubuntu0.18.04.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mecanica_LP1`
--

-- --------------------------------------------------------

--
-- Table structure for table `Cliente`
--

CREATE TABLE `Cliente` (
  `idCliente` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `telefone` int(14) NOT NULL,
  `endereco` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Cliente`
--

INSERT INTO `Cliente` (`idCliente`, `nome`, `telefone`, `endereco`) VALUES
(4, 'aassa', 1212, 'asasas'),
(5, 'asassa bbb', 1121221, 'assasas'),
(6, 'asasa', 12121, 'asasasas'),
(10, 'cliente', 1785214587, 'endereco');

-- --------------------------------------------------------

--
-- Table structure for table `Cliente_Fisico`
--

CREATE TABLE `Cliente_Fisico` (
  `CPF` varchar(11) NOT NULL,
  `RG` varchar(12) NOT NULL,
  `fk_cli_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Cliente_Fisico`
--

INSERT INTO `Cliente_Fisico` (`CPF`, `RG`, `fk_cli_id`) VALUES
('1121212', '121212', 6),
('460704217', '564125', 10);

-- --------------------------------------------------------

--
-- Table structure for table `Cliente_Juridico`
--

CREATE TABLE `Cliente_Juridico` (
  `CNPJ` varchar(14) NOT NULL,
  `IE` varchar(20) NOT NULL,
  `fk_cli_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Cliente_Juridico`
--

INSERT INTO `Cliente_Juridico` (`CNPJ`, `IE`, `fk_cli_id`) VALUES
('1111', '12122', 5);

-- --------------------------------------------------------

--
-- Table structure for table `Mecanico`
--

CREATE TABLE `Mecanico` (
  `idMec` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `especialidade` varchar(30) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Mecanico`
--

INSERT INTO `Mecanico` (`idMec`, `nome`, `especialidade`, `usuario`, `senha`) VALUES
(12, 'Mecanico', 'Funilaria', 'mecanico', 'mecanico'),
(13, 'mecanico2', 'especialidade3', 'mecanico2', 'mecanico');

-- --------------------------------------------------------

--
-- Table structure for table `Ordem_Servico`
--

CREATE TABLE `Ordem_Servico` (
  `idOS` int(11) NOT NULL,
  `data_final` varchar(15) NOT NULL,
  `data_inicial` varchar(15) NOT NULL,
  `total` double NOT NULL,
  `fk_cli_id` int(11) NOT NULL,
  `fk_vei_id` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Ordem_Servico`
--

INSERT INTO `Ordem_Servico` (`idOS`, `data_final`, `data_inicial`, `total`, `fk_cli_id`, `fk_vei_id`) VALUES
(1, '1111', '1111', 0, 4, 'asassa'),
(2, '11111', '1111', 0, 4, 'asassa'),
(3, '11111', '11111', 0, 4, 'asassa'),
(4, '124587', '124587', 0, 10, '4454545as');

-- --------------------------------------------------------

--
-- Table structure for table `OS_Servico`
--

CREATE TABLE `OS_Servico` (
  `fk_os_id` int(11) NOT NULL,
  `fk_ser_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `OS_Servico`
--

INSERT INTO `OS_Servico` (`fk_os_id`, `fk_ser_id`) VALUES
(3, 1),
(4, 5);

-- --------------------------------------------------------

--
-- Table structure for table `Servico`
--

CREATE TABLE `Servico` (
  `idServico` int(11) NOT NULL,
  `valor` double NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `nomeServico` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Servico`
--

INSERT INTO `Servico` (`idServico`, `valor`, `descricao`, `nomeServico`) VALUES
(1, 2222, 'aaaa22', 'wwwwwwwwww'),
(5, 12.7, 'descricao', 'servico2');

-- --------------------------------------------------------

--
-- Table structure for table `Servico_Mecanico`
--

CREATE TABLE `Servico_Mecanico` (
  `idServicoMec` int(11) NOT NULL,
  `fk_ser_idSer` int(11) NOT NULL,
  `fk_mec_idMed` int(11) NOT NULL,
  `fk_vei_chassi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Veiculo`
--

CREATE TABLE `Veiculo` (
  `chassi` varchar(20) NOT NULL,
  `modelo` varchar(20) NOT NULL,
  `placa` varchar(7) NOT NULL,
  `ano_veiculo` int(4) NOT NULL,
  `fk_cli_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Veiculo`
--

INSERT INTO `Veiculo` (`chassi`, `modelo`, `placa`, `ano_veiculo`, `fk_cli_id`) VALUES
('4454545as', 'modelo', 'ads1234', 2017, 10),
('asasasas', 'aasasas', 'asd1234', 1234, 5),
('asassa', 'tttttttttt', 'wsq1235', 4534, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Cliente`
--
ALTER TABLE `Cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indexes for table `Cliente_Fisico`
--
ALTER TABLE `Cliente_Fisico`
  ADD PRIMARY KEY (`CPF`),
  ADD KEY `fk_cli_id` (`fk_cli_id`);

--
-- Indexes for table `Cliente_Juridico`
--
ALTER TABLE `Cliente_Juridico`
  ADD PRIMARY KEY (`CNPJ`),
  ADD KEY `fk_cli_idCliente` (`fk_cli_id`);

--
-- Indexes for table `Mecanico`
--
ALTER TABLE `Mecanico`
  ADD PRIMARY KEY (`idMec`);

--
-- Indexes for table `Ordem_Servico`
--
ALTER TABLE `Ordem_Servico`
  ADD PRIMARY KEY (`idOS`),
  ADD KEY `fk_vei_id` (`fk_vei_id`),
  ADD KEY `fk_cli_Cliente` (`fk_cli_id`);

--
-- Indexes for table `OS_Servico`
--
ALTER TABLE `OS_Servico`
  ADD KEY `fk_ser_id` (`fk_ser_id`),
  ADD KEY `fk_os_id` (`fk_os_id`);

--
-- Indexes for table `Servico`
--
ALTER TABLE `Servico`
  ADD PRIMARY KEY (`idServico`);

--
-- Indexes for table `Servico_Mecanico`
--
ALTER TABLE `Servico_Mecanico`
  ADD PRIMARY KEY (`idServicoMec`),
  ADD KEY `pk_vei_chassi` (`fk_vei_chassi`),
  ADD KEY `fk_mec_idMec` (`fk_mec_idMed`),
  ADD KEY `fk_ser_idSer` (`fk_ser_idSer`);

--
-- Indexes for table `Veiculo`
--
ALTER TABLE `Veiculo`
  ADD PRIMARY KEY (`chassi`),
  ADD KEY `fk_idCliente` (`fk_cli_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Cliente`
--
ALTER TABLE `Cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `Mecanico`
--
ALTER TABLE `Mecanico`
  MODIFY `idMec` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `Ordem_Servico`
--
ALTER TABLE `Ordem_Servico`
  MODIFY `idOS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `Servico`
--
ALTER TABLE `Servico`
  MODIFY `idServico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `Servico_Mecanico`
--
ALTER TABLE `Servico_Mecanico`
  MODIFY `idServicoMec` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Cliente_Fisico`
--
ALTER TABLE `Cliente_Fisico`
  ADD CONSTRAINT `fk_cli_id` FOREIGN KEY (`fk_cli_id`) REFERENCES `Cliente` (`idCliente`);

--
-- Constraints for table `Cliente_Juridico`
--
ALTER TABLE `Cliente_Juridico`
  ADD CONSTRAINT `fk_cli_idCliente` FOREIGN KEY (`fk_cli_id`) REFERENCES `Cliente` (`idCliente`);

--
-- Constraints for table `Ordem_Servico`
--
ALTER TABLE `Ordem_Servico`
  ADD CONSTRAINT `fk_cli_Cliente` FOREIGN KEY (`fk_cli_id`) REFERENCES `Cliente` (`idCliente`),
  ADD CONSTRAINT `fk_vei_id` FOREIGN KEY (`fk_vei_id`) REFERENCES `Veiculo` (`chassi`);

--
-- Constraints for table `OS_Servico`
--
ALTER TABLE `OS_Servico`
  ADD CONSTRAINT `fk_os_id` FOREIGN KEY (`fk_os_id`) REFERENCES `Ordem_Servico` (`idOS`),
  ADD CONSTRAINT `fk_ser_id` FOREIGN KEY (`fk_ser_id`) REFERENCES `Servico` (`idServico`);

--
-- Constraints for table `Servico_Mecanico`
--
ALTER TABLE `Servico_Mecanico`
  ADD CONSTRAINT `fk_mec_idMec` FOREIGN KEY (`fk_mec_idMed`) REFERENCES `Mecanico` (`idMec`),
  ADD CONSTRAINT `fk_ser_idSer` FOREIGN KEY (`fk_ser_idSer`) REFERENCES `Servico` (`idServico`);

--
-- Constraints for table `Veiculo`
--
ALTER TABLE `Veiculo`
  ADD CONSTRAINT `fk_idCliente` FOREIGN KEY (`fk_cli_id`) REFERENCES `Cliente` (`idCliente`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
