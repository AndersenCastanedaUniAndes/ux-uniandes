import { useEffect } from 'react';

const HideText = ({ searchText }) => {
  useEffect(() => {
    if (!searchText) return;

    // Seleccionar todos los nodos de texto en el cuerpo del documento
    const walker = document.createTreeWalker(document.body, NodeFilter.SHOW_TEXT, null, false);

    while (walker.nextNode()) {
      const node = walker.currentNode;
      const parent = node.parentNode;
      
      if (node.nodeValue.includes(searchText)) {
        // Crear un span con el texto transparente
        const highlighted = document.createElement('span');
        highlighted.innerHTML = node.nodeValue.replace(
          new RegExp(`(${searchText})`, 'gi'),
          `<span style='color:transparent;'>$1</span>`
        );
        
        parent.replaceChild(highlighted, node);
      }
    }
  }, [searchText]);

  return null;
};

export default HideText;