#Pablo Arriola
#Diego Sosa

import networkx as nx
import matplotlib.pyplot as plt


def generateGraphFromFile():
    g = nx.Graph()
    nodes = []
    with open("File.txt") as f:
        for line in f:
            line = line.replace("\n","")
            lineArr = line.split(" ")
            dummy = tuple(lineArr[0:3])
            nodes.append(dummy)


    g.add_weighted_edges_from(nodes)
    matrixPaths = nx.floyd_warshall_numpy(g,nodelist=None, weight='weight')
    #print matrixPaths
    listNodes = g.nodes()
    #print listNodes
    center = nx.center(g,e=None)
    #print center
    pos=nx.spring_layout(g)
    return (center, matrixPaths, listNodes,g,pos)


while(True):
    (center,matrixPaths,listNodes,g,pos) =generateGraphFromFile()
        
    print "1. Ruta más corta entre dos ciudades"
    print "2. Indicar nombre de la ciudad en el centro"
    print "3. Modificar Grafo"
    print "4. Finalizar programa"
    op = int(raw_input())

    if op==1:
        print "Ingrese Ciudad 1"
        c1 = raw_input()
        print "Ingrese Ciudad 2"
        c2 = raw_input()
        if c1 in listNodes:
            if c2 in listNodes:
                i =listNodes.index(c1)
                j = listNodes.index(c2)
                print matrixPaths[i,j]
            else :
                print "ciudad 2 no está"
        else :
            print "ciudad 1 no está"

                
    elif op==2:
        print center
    elif op==3:
        print "a)hay interrupción de tráfico entre un par de ciudades"
        print "b)se establece una conexión entre ciudad1 y ciudad2 con valor de x KM de distancia. "
        op = raw_input()
        if op == "a":
            print "Ingrese Ciudad 1"
            c1 = raw_input()
            print "Ingrese Ciudad 2"
            c2 = raw_input()
            if c1 in listNodes:
                if c2 in listNodes:
                    with open('file.txt', 'a') as file:
                        file.write(c1+" "+c2+" "+"99999\n")
                else :
                    print "ciudad 2 no está"
            else :
                print "ciudad 1 no está"
        if op == "b":
            print "Ingrese Ciudad 1"
            c1 = raw_input()
            print "Ingrese Ciudad 2"
            c2 = raw_input()
            print "Ingrese la distancia en km entre las ciudades"
            x = raw_input()
            if c1 in listNodes:
                if c2 in listNodes:
                    with open('file.txt', 'a') as file:
                        file.write(c1+" "+c2+" "+x+"\n")
                else :
                    print "ciudad 2 no está"
            else :
                print "ciudad 1 no está"
    elif op==4:
        nx.draw_circular(g)
        labels=nx.draw_networkx_labels(g,pos=nx.spring_layout(g))
        break
