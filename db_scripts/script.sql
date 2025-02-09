CREATE TABLE `nova_tarefa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nomeTarefa` varchar(100) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `status` varchar(10) NOT NULL,
  `dataCriacao` date NOT NULL,
  PRIMARY KEY (`id`)
);

select * from nova_tarefa;
