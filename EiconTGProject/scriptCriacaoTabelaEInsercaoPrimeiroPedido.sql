Database: `eicontg`.


Estrutura da tabela `pedido`:
CREATE TABLE `pedido` (
  `id` int(11) NOT NULL,
  `numControle` int(11) NOT NULL,
  `dataCadastro` text NOT NULL,
  `nomeProduto` text NOT NULL,
  `valorProduto` float NOT NULL,
  `quantidadeProduto` int(11) NOT NULL,
  `codigoCliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



Primeiro Pedido:
INSERT INTO `pedido` (`id`, `numControle`, `dataCadastro`, `nomeProduto`, `valorProduto`, `quantidadeProduto`, `codigoCliente`) VALUES
(1, 43243, '12/12/2010', 'faca', 213, 5, 1),
(1, 43243, '12 de 12 de 2010', 'faca', 213, 5, 1);


COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
