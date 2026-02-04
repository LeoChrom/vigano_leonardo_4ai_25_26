

namespace Othello
{
    public class Tabellone
    {
        private Cella[,] celle;
        public int conteggioPedineBianche { get; private set; }
        public int conteggioPedineNere { get; private set; }

       public Cella[,] Celle
       {
            get
            {
                Cella[,] CelleDaRitornare = new Cella[8, 8];
                for (int i = 0; i < 8; i++)
                {
                    for (int j = 0; j < 8; j++)
                    {
                        CelleDaRitornare[i, j] = new Cella(celle[i, j]);
                    }
                }
                return CelleDaRitornare;
            }
            private set
            {
                if (value.GetLength(0) != 8 || value.GetLength(1) != 8)
                    throw new ArgumentException("la matrice deve essere 8x8");
                celle = value;
            }
      
       }
        public Tabellone()
        {
            celle = new Cella[8, 8];
            for (int x = 0; x < 8; x++)
            {
                for (int y = 0; y < 8; y++)
                {
                    celle[x, y] = new Cella();
                }
            }

            CelleDefault();

        }

        public Tabellone(Tabellone tabellone)
        {
            Celle = tabellone.Celle;
        }

        private void CelleDefault()
        {
            celle[3, 3].SetCella(Cella.Colori.Bianco);

            celle[4, 4].SetCella(Cella.Colori.Bianco);

            celle[3, 4].SetCella(Cella.Colori.Nero);

            celle[4, 3].SetCella(Cella.Colori.Nero);


            conteggioPedineBianche = 2;
            conteggioPedineNere = 2;

        }

        public Posizione[] GetMossePossibili(Cella.Colori colore)
        {
            if (colore != Cella.Colori.Nero && colore != Cella.Colori.Bianco) throw new ArgumentException("Inserire un colore valido: Nero o Bianco");

            List<Posizione> mossePossibili = new();
            Cella.Colori coloreOpposto = colore == Cella.Colori.Bianco ? Cella.Colori.Nero : Cella.Colori.Bianco;
            int[] direzioni = { -1, 0, 1 };

            for (int rig = 0; rig < 8; rig++)
            {
                for (int col = 0; col < 8; col++)
                {
                    if (!Celle[rig, col].Occupazione)
                    {
                        foreach (int dirx in direzioni)
                        {
                            foreach (int diry in direzioni)
                            {
                                if (dirx == 0 && diry == 0) continue;

                                int x = rig + dirx, y = col + diry;
                                bool avversarioTrovato = false;

                                while (x >= 0 && x < 8 && y >= 0 && y < 8 && Celle[x, y].Occupazione && Celle[x, y].Colore == coloreOpposto)
                                {
                                    x += dirx;
                                    y += diry;
                                    avversarioTrovato = true;
                                }

                                if (avversarioTrovato && x >= 0 && x < 8 && y >= 0 && y < 8 && Celle[x, y].Occupazione && Celle[x, y].Colore == colore)
                                {
                                    mossePossibili.Add(new Posizione(rig, col));
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            return mossePossibili.ToArray();

        } //restutuisce le posizioni dove è possibilie piazzare la pedina

        public void PulisciTabellone()
        {
            for (int x = 0; x < 8; x++)
            {
                for (int y = 0; y < 8; y++)
                {
                    celle[x, y].ResetCella();
                }
            }

            CelleDefault();

        }


        public void SetPosizione(Posizione pos, Cella.Colori colore)
        {
            if(!GetMossePossibili(colore).Contains(pos))
            {
                throw new Exception("posizione invalida, posizionare la pedina in una cella valida");
            }

            celle[pos.Riga, pos.Colonna].SetCella(colore);
            if (colore == Cella.Colori.Nero) conteggioPedineNere += 1;
            else conteggioPedineBianche += 1;
            CambiaPedine(pos, colore);

        }


        public bool ControllaVincita(Cella.Colori colore)
        {
            if (colore == Cella.Colori.Vuoto) throw new Exception("sono accettati solo il bianco od il nero come colori");

            int coloreAvversario = (colore == Cella.Colori.Bianco) ? conteggioPedineNere : conteggioPedineBianche;
            int coloreAttuale = (colore == Cella.Colori.Bianco) ? conteggioPedineBianche : conteggioPedineNere;

            bool mosseDisponibiliAvversario = GetMossePossibili((colore == Cella.Colori.Bianco) ? Cella.Colori.Nero : Cella.Colori.Bianco).Length > 0;

            bool mosseDisponibili = GetMossePossibili((colore == Cella.Colori.Bianco) ? Cella.Colori.Bianco : Cella.Colori.Nero).Length > 0;

            if (!mosseDisponibiliAvversario && !mosseDisponibili && coloreAttuale > coloreAvversario)
            {
                return true;
            }

            return false;
        }

        public bool ControllaPareggio()
        {
            return !(ControllaVincita(Cella.Colori.Bianco)) && GetMossePossibili(Cella.Colori.Bianco).Length == 0 && !(ControllaVincita(Cella.Colori.Nero)) && GetMossePossibili(Cella.Colori.Nero).Length == 0 && conteggioPedineBianche == conteggioPedineNere;
        }

        private void CambiaPedine(Posizione pos, Cella.Colori coloreGiocatore)
        {
            List<Posizione> CelleDaCambaire = new List<Posizione>();
            Posizione[] direzioniMovimento = new Posizione[]
            {
                new Posizione(1, 1),
                new Posizione(-1, -1),
                new Posizione(-1, 1),
                new Posizione(1, -1),
                new Posizione(-1, 0),
                new Posizione(1, 0),
                new Posizione(0, 1),
                new Posizione(0, -1)
            };
            
            Cella.Colori coloreAvversario = coloreGiocatore == Cella.Colori.Bianco ? Cella.Colori.Nero : Cella.Colori.Bianco;
            int row;
            int col;
            foreach (Posizione direzione in direzioniMovimento)
            {
                bool continua = true;
                row = pos.Riga;
                col = pos.Colonna;
                
                
                List<Posizione> SubList = new List<Posizione>();
                while (continua)
                {
                    row += direzione.Riga;
                    col += direzione.Colonna;

                    if (row >= 0 && row <= 7 && col >= 0  && col <= 7)
                    {
                        if (Celle[row, col].Colore == coloreAvversario)
                        {
                            SubList.Add(new Posizione(row, col));
                        }
                        else if (Celle[row, col].Colore == coloreGiocatore)
                        {
                            continua = false;
                        }
                        else
                        {
                            continua = false;
                            SubList.Clear();
                        }
                    }
                    else
                    {
                        SubList.Clear();
                        continua = false;
                    }
                }
                CelleDaCambaire.AddRange(SubList);
            }

            int decremento = 0;
            foreach (Posizione cella in CelleDaCambaire)
            {
                decremento += 1;
                celle[cella.Riga, cella.Colonna].SetCella(coloreGiocatore);
            }

            if (coloreGiocatore == Cella.Colori.Bianco)
            {
                conteggioPedineBianche += decremento;
                conteggioPedineNere -= decremento;
            } 
            else
            {
                conteggioPedineNere += decremento;
                conteggioPedineBianche -= decremento;
            }
        }


    }
}